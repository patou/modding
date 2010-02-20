package com.sfeir.modding.generator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import com.google.gwt.core.ext.Generator;
import com.google.gwt.core.ext.GeneratorContext;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.typeinfo.JClassType;
import com.google.gwt.core.ext.typeinfo.NotFoundException;
import com.sfeir.modding.client.app.Activity;
import com.sfeir.modding.client.showcase.ShowcaseConstants;
import com.sfeir.modding.client.showcase.ShowcaseAnnotations.ShowcaseData;
import com.sfeir.modding.client.showcase.ShowcaseAnnotations.ShowcaseSource;

/**
 * Generate the source code, css styles, and raw source used in the Showcase
 * examples.
 */
public class ShowcaseGenerator extends Generator {
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

  @Override
  public String generate(TreeLogger logger, GeneratorContext context,
      String typeName) throws UnableToCompleteException {
    this.logger = logger;
    this.context = context;
    this.classLoader = Thread.currentThread().getContextClassLoader();

    // Only generate files on the first permutation
    if (!isFirstPass()) {
      return null;
    }

    // Get the Showcase ContentWidget subtypes to examine
    JClassType cwType = null;
    try {
      cwType = context.getTypeOracle().getType(Activity.class.getName());
    } catch (NotFoundException e) {
      logger.log(TreeLogger.ERROR, "Cannot find ContentWidget class", e);
      throw new UnableToCompleteException();
    }
    JClassType[] types = cwType.getSubtypes();

    // Generate the source and raw source files
    for (JClassType type : types) {
      generateSourceFiles(type);
    }
    return null;
  }

  /**
   * Set the full contents of a resource in the public directory.
   * 
   * @param partialPath the path to the file relative to the public directory
   * @param contents the file contents
   */
  private void createPublicResource(String partialPath, String contents) {
    try {
      OutputStream outStream = context.tryCreateResource(logger, partialPath);
      outStream.write(contents.getBytes());
      context.commitResource(logger, outStream);
    } catch (UnableToCompleteException e) {
      logger.log(TreeLogger.ERROR, "Failed while writing", e);
    } catch (IOException e) {
      logger.log(TreeLogger.ERROR, "Failed while writing", e);
    }
  }

  /**
   * Generate the formatted source code for a {@link ContentWidget}.
   * 
   * @param type the {@link ContentWidget} subclass
   */
  private void generateSourceFiles(JClassType type)
      throws UnableToCompleteException {
    // Get the file contents
    String filename = type.getQualifiedSourceName().replace('.', '/') + ".java";
    String fileContents = getResourceContents(filename);

    // Get each data code block
    String formattedSource = fileContents;
    /*String dataTag = "@" + ShowcaseData.class.getSimpleName();
    String sourceTag = "@" + ShowcaseSource.class.getSimpleName();
    int dataTagIndex = fileContents.indexOf(dataTag);
    int srcTagIndex = fileContents.indexOf(sourceTag);
    while (dataTagIndex >= 0 || srcTagIndex >= 0) {
      if (dataTagIndex >= 0 && (dataTagIndex < srcTagIndex || srcTagIndex < 0)) {
        // Get the boundaries of a DATA tag
        int beginIndex = fileContents.lastIndexOf("    /*", dataTagIndex);
        int beginTagIndex = fileContents.lastIndexOf("\n", dataTagIndex) + 1;
        int endTagIndex = fileContents.indexOf("\n", dataTagIndex) + 1;
        int endIndex = fileContents.indexOf(";", beginIndex) + 1;

        // Add to the formatted source
        String srcData = fileContents.substring(beginIndex, beginTagIndex)
            + fileContents.substring(endTagIndex, endIndex);
        formattedSource += srcData + "\n\n";

        // Get next tag
        dataTagIndex = fileContents.indexOf(dataTag, endIndex + 1);
      } else {
        // Get the boundaries of a SRC tag
        int beginIndex = fileContents.lastIndexOf("/*", srcTagIndex) - 2;
        int beginTagIndex = fileContents.lastIndexOf("\n", srcTagIndex) + 1;
        int endTagIndex = fileContents.indexOf("\n", srcTagIndex) + 1;
        int endIndex = fileContents.indexOf("\n}\n", beginIndex) + 3;

        // Add to the formatted source
        String srcCode = fileContents.substring(beginIndex, beginTagIndex)
            + fileContents.substring(endTagIndex, endIndex);
        formattedSource += srcCode + "\n\n";

        // Get the next tag
        srcTagIndex = fileContents.indexOf(sourceTag, endIndex + 1);
      }
    }*/

    // Make the source pretty
    formattedSource = formattedSource.replace("<", "&lt;");
    formattedSource = formattedSource.replace(">", "&gt;");
    //formattedSource = formattedSource.replace("* \n     */\n", "*/\n");
    formattedSource = "<pre>" + formattedSource + "</pre>";

    // Save the source code to a file
    String dstPath = ShowcaseConstants.DST_SOURCE_EXAMPLE
        + type.getSimpleSourceName() + ".html";
    createPublicResource(dstPath, formattedSource);
    logger.log(TreeLogger.INFO, "Generate source file : " + filename);
  }

  /**
   * Get the full contents of a resource.
   * 
   * @param path the path to the resource
   * @return the contents of the resource
   */
  private String getResourceContents(String path)
      throws UnableToCompleteException {
    InputStream in = classLoader.getResourceAsStream(path);
    if (in == null) {
      logger.log(TreeLogger.ERROR, "Resource not found: " + path);
      throw new UnableToCompleteException();
    }

    StringBuffer fileContentsBuf = new StringBuffer();
    BufferedReader br = null;
    try {
      br = new BufferedReader(new InputStreamReader(in));
      String temp;
      while ((temp = br.readLine()) != null) {
        fileContentsBuf.append(temp).append('\n');
      }
    } catch (IOException e) {
      logger.log(TreeLogger.ERROR, "Cannot read resource", e);
      throw new UnableToCompleteException();
    } finally {
      if (br != null) {
        try {
          br.close();
        } catch (IOException e) {
        }
      }
    }

    // Return the file contents as a string
    return fileContentsBuf.toString();
  }

  /**
   * Ensure that we only generate files once by creating a placeholder file,
   * then looking for it on subsequent generates.
   * 
   * @return true if this is the first pass, false if not
   */
  private boolean isFirstPass() {
    String placeholder = ShowcaseConstants.DST_SOURCE + "generated";
    try {
      OutputStream outStream = context.tryCreateResource(logger, placeholder);
      if (outStream == null) {
        return false;
      } else {
        context.commitResource(logger, outStream);
      }
    } catch (UnableToCompleteException e) {
      logger.log(TreeLogger.ERROR, "Unable to generate", e);
      return false;
    }
    return true;
  }
}
