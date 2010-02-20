package com.sfeir.modding.generator;

import java.io.PrintWriter;

import mx4j.log.Logger;

import com.google.gwt.core.ext.Generator;
import com.google.gwt.core.ext.GeneratorContext;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.typeinfo.JClassType;
import com.google.gwt.core.ext.typeinfo.NotFoundException;
import com.google.gwt.core.ext.typeinfo.TypeOracle;
import com.google.gwt.user.rebind.ClassSourceFileComposerFactory;
import com.google.gwt.user.rebind.SourceWriter;
import com.sfeir.modding.client.app.Activity;
import com.sfeir.modding.client.content.ModdingAction;

/**
 * Generate the factory to dynamicly create Activity by there name
 */
public class ModdingGenerator extends Generator {
  /**
   * The class loader used to get resources.
   */
  private ClassLoader classLoader = null;

  /**
   * The generator context.
   */
  private GeneratorContext context = null;

  /**
   * The {@link TreeLogger} used to log messages.
   */
  private TreeLogger logger = null;

private TypeOracle typeOracle;

  @Override
  public String generate(TreeLogger logger, GeneratorContext context,
      String typeName) throws UnableToCompleteException {
    this.logger = logger;
    this.context = context;
    this.classLoader = Thread.currentThread().getContextClassLoader();

    typeOracle = context.getTypeOracle();
    try {
        JClassType type = typeOracle.getType(typeName);
        
        String packageName = type.getPackage().getName();
        String simpleName = type.getSimpleSourceName() + "_Generated";
        ClassSourceFileComposerFactory composer = new ClassSourceFileComposerFactory(packageName, simpleName);
        PrintWriter printWriter = context.tryCreate(logger, composer.getCreatedPackage(), composer.getCreatedClassShortName());
        if (printWriter == null) return null; 
        composer.addImplementedInterface(typeName);
        composer.setSuperclass("java.lang.Object"); 
        SourceWriter writer = composer.createSourceWriter(context, printWriter);
        writer.indent();
        generateConstructor(writer, simpleName);
        writer.println("public com.sfeir.modding.client.app.Activity createActivity(String name) {");
        writer.indent();
        
        generateFactory(writer);
        writer.outdent();
        writer.println("}");
        writer.outdent();
        writer.commit(logger);
        
        logger.log(TreeLogger.WARN, composer.getCreatedClassName());
        return composer.getCreatedClassName();
    } catch (Exception e) {
        logger.log(TreeLogger.ERROR, "Unable to generate the activity factory", e);
        throw new UnableToCompleteException();
    }
    // Get the Showcase ContentWidget subtypes to examine
    
  }

  /** 
   * Generate source code for the default constructor. Create 
default 
   * constructor, call super(), and insert all key/value pairs from 
   * the resoruce bundle. 
   * 
   * @param sourceWriter Source writer to output source code 
 * @param className 
   */ 
  private void generateConstructor(SourceWriter sourceWriter, String className) { 
      // init resource bundle 
      // start constructor source generation 
      sourceWriter.println("public " + className + "() { "); 
      sourceWriter.indent(); 
      sourceWriter.println("super();"); 
      // end constructor source generation 
      sourceWriter.outdent(); 
      sourceWriter.println("}"); 
  } 
  
  /**
   * Generate the factory
   * @param writer
   * @throws UnableToCompleteException
   */
  private void generateFactory (SourceWriter writer) throws UnableToCompleteException {
      JClassType cwType = null;
      try {
        
        cwType = typeOracle.getType(Activity.class.getName());
        
      } catch (NotFoundException e) {
        logger.log(TreeLogger.ERROR, "Cannot find Activity classes", e);
        throw new UnableToCompleteException();
      }
      JClassType[] types = cwType.getSubtypes();
      String defaultActivity = null;
      writer.println("if (name != null && name.length() > 0) {");
      writer.indent();
      // Generate the source and raw source files
      for (JClassType type : types) {
          if (type.isDefaultInstantiable()) {
              writer.print("if (name.equals(\"" + Generator.escape(type.getName())+"\") || name.equals(\"" + Generator.escape(type.getQualifiedSourceName())+"\")");
              if (type.isAnnotationPresent(ModdingAction.class)) {
                  ModdingAction annotation = type.getAnnotation(ModdingAction.class);
                  if (annotation.value() != null) {
                      writer.print(" || name.equals(\"" + Generator.escape(annotation.value())+"\")");
                  }
                  if (annotation.defaultActivity()) {
                      defaultActivity = type.getParameterizedQualifiedSourceName();
                  }
              }
              writer.println(") {");
              writer.indent();
              writer.println("return new "+type.getParameterizedQualifiedSourceName()+"();");
              writer.outdent();
              writer.println("}");
          }
      }
      writer.outdent();
      writer.println("}");
      if (defaultActivity == null) {
          writer.println("return null;");
      }
      else {
          writer.println("return new "+defaultActivity+"();");
      }
  }
}
