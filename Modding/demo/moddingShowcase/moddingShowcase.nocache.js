function moddingShowcase(){
  var $intern_0 = '', $intern_29 = '" for "gwt:onLoadErrorFn"', $intern_27 = '" for "gwt:onPropertyErrorFn"', $intern_12 = '"><\/script>', $intern_14 = '#', $intern_57 = '.cache.html', $intern_16 = '/', $intern_51 = '083CD48C71445040DF3FD22809918AC6', $intern_52 = '4A0405C7F861962D41B6CA04586BE91D', $intern_65 = '<script defer="defer">moddingShowcase.onInjectionDone(\'moddingShowcase\')<\/script>', $intern_11 = '<script id="', $intern_24 = '=', $intern_15 = '?', $intern_53 = 'BF9C731D13DC967AE68BF0CF57B21354', $intern_26 = 'Bad handler "', $intern_54 = 'C5C1B486BC7E5DDB4B2751C797361764', $intern_55 = 'CF67D11230FFCDA131A6674D9AFD3FB2', $intern_56 = 'DDC44EC31B6DAE56D3156A5F9DC1A1A8', $intern_64 = 'DOMContentLoaded', $intern_13 = 'SCRIPT', $intern_10 = '__gwt_marker_moddingShowcase', $intern_36 = 'android', $intern_17 = 'base', $intern_4 = 'begin', $intern_3 = 'bootstrap', $intern_19 = 'clear.cache.gif', $intern_23 = 'content', $intern_9 = 'end', $intern_45 = 'gecko', $intern_46 = 'gecko1_8', $intern_5 = 'gwt.codesvr=', $intern_6 = 'gwt.hosted=', $intern_7 = 'gwt.hybrid', $intern_58 = 'gwt/standard/standard.css', $intern_28 = 'gwt:onLoadErrorFn', $intern_25 = 'gwt:onPropertyErrorFn', $intern_22 = 'gwt:property', $intern_63 = 'head', $intern_49 = 'hosted.html?moddingShowcase', $intern_62 = 'href', $intern_44 = 'ie6', $intern_43 = 'ie8', $intern_30 = 'iframe', $intern_18 = 'img', $intern_35 = 'iphone', $intern_31 = "javascript:''", $intern_59 = 'link', $intern_48 = 'loadExternalRefs', $intern_20 = 'meta', $intern_1 = 'moddingShowcase', $intern_33 = 'moduleRequested', $intern_8 = 'moduleStartup', $intern_42 = 'msie', $intern_21 = 'name', $intern_37 = 'nophone', $intern_39 = 'opera', $intern_34 = 'phone.useragent', $intern_32 = 'position:absolute;width:0;height:0;border:none', $intern_60 = 'rel', $intern_41 = 'safari', $intern_50 = 'selectingPermutation', $intern_2 = 'startup', $intern_61 = 'stylesheet', $intern_47 = 'unknown', $intern_38 = 'user.agent', $intern_40 = 'webkit';
  var $wnd = window, $doc = document, $stats = $wnd.__gwtStatsEvent?function(a){
    return $wnd.__gwtStatsEvent(a);
  }
  :null, $sessionId = $wnd.__gwtStatsSessionId?$wnd.__gwtStatsSessionId:null, scriptsDone, loadDone, bodyDone, base = $intern_0, metaProps = {}, values = [], providers = [], answers = [], onLoadErrorFunc, propertyErrorFunc;
  $stats && $stats({moduleName:$intern_1, sessionId:$sessionId, subSystem:$intern_2, evtGroup:$intern_3, millis:(new Date).getTime(), type:$intern_4});
  if (!$wnd.__gwt_stylesLoaded) {
    $wnd.__gwt_stylesLoaded = {};
  }
  if (!$wnd.__gwt_scriptsLoaded) {
    $wnd.__gwt_scriptsLoaded = {};
  }
  function isHostedMode(){
    var result = false;
    try {
      var query = $wnd.location.search;
      return (query.indexOf($intern_5) != -1 || (query.indexOf($intern_6) != -1 || $wnd.external && $wnd.external.gwtOnLoad)) && query.indexOf($intern_7) == -1;
    }
     catch (e) {
    }
    isHostedMode = function(){
      return result;
    }
    ;
    return result;
  }

  function maybeStartModule(){
    if (scriptsDone && loadDone) {
      var iframe = $doc.getElementById($intern_1);
      var frameWnd = iframe.contentWindow;
      if (isHostedMode()) {
        frameWnd.__gwt_getProperty = function(name){
          return computePropValue(name);
        }
        ;
      }
      moddingShowcase = null;
      frameWnd.gwtOnLoad(onLoadErrorFunc, $intern_1, base);
      $stats && $stats({moduleName:$intern_1, sessionId:$sessionId, subSystem:$intern_2, evtGroup:$intern_8, millis:(new Date).getTime(), type:$intern_9});
    }
  }

  function computeScriptBase(){
    var thisScript, markerId = $intern_10, markerScript;
    $doc.write($intern_11 + markerId + $intern_12);
    markerScript = $doc.getElementById(markerId);
    thisScript = markerScript && markerScript.previousSibling;
    while (thisScript && thisScript.tagName != $intern_13) {
      thisScript = thisScript.previousSibling;
    }
    function getDirectoryOfFile(path){
      var hashIndex = path.lastIndexOf($intern_14);
      if (hashIndex == -1) {
        hashIndex = path.length;
      }
      var queryIndex = path.indexOf($intern_15);
      if (queryIndex == -1) {
        queryIndex = path.length;
      }
      var slashIndex = path.lastIndexOf($intern_16, Math.min(queryIndex, hashIndex));
      return slashIndex >= 0?path.substring(0, slashIndex + 1):$intern_0;
    }

    ;
    if (thisScript && thisScript.src) {
      base = getDirectoryOfFile(thisScript.src);
    }
    if (base == $intern_0) {
      var baseElements = $doc.getElementsByTagName($intern_17);
      if (baseElements.length > 0) {
        base = baseElements[baseElements.length - 1].href;
      }
       else {
        base = getDirectoryOfFile($doc.location.href);
      }
    }
     else if (base.match(/^\w+:\/\//)) {
    }
     else {
      var img = $doc.createElement($intern_18);
      img.src = base + $intern_19;
      base = getDirectoryOfFile(img.src);
    }
    if (markerScript) {
      markerScript.parentNode.removeChild(markerScript);
    }
  }

  function processMetas(){
    var metas = document.getElementsByTagName($intern_20);
    for (var i = 0, n = metas.length; i < n; ++i) {
      var meta = metas[i], name = meta.getAttribute($intern_21), content;
      if (name) {
        if (name == $intern_22) {
          content = meta.getAttribute($intern_23);
          if (content) {
            var value, eq = content.indexOf($intern_24);
            if (eq >= 0) {
              name = content.substring(0, eq);
              value = content.substring(eq + 1);
            }
             else {
              name = content;
              value = $intern_0;
            }
            metaProps[name] = value;
          }
        }
         else if (name == $intern_25) {
          content = meta.getAttribute($intern_23);
          if (content) {
            try {
              propertyErrorFunc = eval(content);
            }
             catch (e) {
              alert($intern_26 + content + $intern_27);
            }
          }
        }
         else if (name == $intern_28) {
          content = meta.getAttribute($intern_23);
          if (content) {
            try {
              onLoadErrorFunc = eval(content);
            }
             catch (e) {
              alert($intern_26 + content + $intern_29);
            }
          }
        }
      }
    }
  }

  function unflattenKeylistIntoAnswers(propValArray, value){
    var answer = answers;
    for (var i = 0, n = propValArray.length - 1; i < n; ++i) {
      answer = answer[propValArray[i]] || (answer[propValArray[i]] = []);
    }
    answer[propValArray[n]] = value;
  }

  function computePropValue(propName){
    var value = providers[propName](), allowedValuesMap = values[propName];
    if (value in allowedValuesMap) {
      return value;
    }
    var allowedValuesList = [];
    for (var k in allowedValuesMap) {
      allowedValuesList[allowedValuesMap[k]] = k;
    }
    if (propertyErrorFunc) {
      propertyErrorFunc(propName, allowedValuesList, value);
    }
    throw null;
  }

  var frameInjected;
  function maybeInjectFrame(){
    if (!frameInjected) {
      frameInjected = true;
      var iframe = $doc.createElement($intern_30);
      iframe.src = $intern_31;
      iframe.id = $intern_1;
      iframe.style.cssText = $intern_32;
      iframe.tabIndex = -1;
      $doc.body.appendChild(iframe);
      $stats && $stats({moduleName:$intern_1, sessionId:$sessionId, subSystem:$intern_2, evtGroup:$intern_8, millis:(new Date).getTime(), type:$intern_33});
      iframe.contentWindow.location.replace(base + initialHtml);
    }
  }

  providers[$intern_34] = function(){
    var ua = navigator.userAgent.toLowerCase();
    if (ua.indexOf($intern_35) != -1) {
      return $intern_35;
    }
     else if (ua.indexOf($intern_36) != -1) {
      return $intern_36;
    }
    return $intern_37;
  }
  ;
  values[$intern_34] = {android:0, iphone:1, nophone:2};
  providers[$intern_38] = function(){
    var ua = navigator.userAgent.toLowerCase();
    var makeVersion = function(result){
      return parseInt(result[1]) * 1000 + parseInt(result[2]);
    }
    ;
    if (ua.indexOf($intern_39) != -1) {
      return $intern_39;
    }
     else if (ua.indexOf($intern_40) != -1) {
      return $intern_41;
    }
     else if (ua.indexOf($intern_42) != -1) {
      if (document.documentMode >= 8) {
        return $intern_43;
      }
       else {
        var result = /msie ([0-9]+)\.([0-9]+)/.exec(ua);
        if (result && result.length == 3) {
          var v = makeVersion(result);
          if (v >= 6000) {
            return $intern_44;
          }
        }
      }
    }
     else if (ua.indexOf($intern_45) != -1) {
      var result = /rv:([0-9]+)\.([0-9]+)/.exec(ua);
      if (result && result.length == 3) {
        if (makeVersion(result) >= 1008)
          return $intern_46;
      }
      return $intern_45;
    }
    return $intern_47;
  }
  ;
  values[$intern_38] = {gecko:0, gecko1_8:1, ie6:2, ie8:3, opera:4, safari:5};
  moddingShowcase.onScriptLoad = function(){
    if (frameInjected) {
      loadDone = true;
      maybeStartModule();
    }
  }
  ;
  moddingShowcase.onInjectionDone = function(){
    scriptsDone = true;
    $stats && $stats({moduleName:$intern_1, sessionId:$sessionId, subSystem:$intern_2, evtGroup:$intern_48, millis:(new Date).getTime(), type:$intern_9});
    maybeStartModule();
  }
  ;
  computeScriptBase();
  var strongName;
  var initialHtml;
  if (isHostedMode()) {
    if ($wnd.external && ($wnd.external.initModule && $wnd.external.initModule($intern_1))) {
      $wnd.location.reload();
      return;
    }
    initialHtml = $intern_49;
    strongName = $intern_0;
  }
  processMetas();
  $stats && $stats({moduleName:$intern_1, sessionId:$sessionId, subSystem:$intern_2, evtGroup:$intern_3, millis:(new Date).getTime(), type:$intern_50});
  if (!isHostedMode()) {
    try {
      unflattenKeylistIntoAnswers([$intern_36, $intern_41], $intern_51);
      unflattenKeylistIntoAnswers([$intern_35, $intern_41], $intern_51);
      unflattenKeylistIntoAnswers([$intern_37, $intern_41], $intern_51);
      unflattenKeylistIntoAnswers([$intern_36, $intern_39], $intern_52);
      unflattenKeylistIntoAnswers([$intern_35, $intern_39], $intern_52);
      unflattenKeylistIntoAnswers([$intern_37, $intern_39], $intern_52);
      unflattenKeylistIntoAnswers([$intern_36, $intern_43], $intern_53);
      unflattenKeylistIntoAnswers([$intern_35, $intern_43], $intern_53);
      unflattenKeylistIntoAnswers([$intern_37, $intern_43], $intern_53);
      unflattenKeylistIntoAnswers([$intern_36, $intern_45], $intern_54);
      unflattenKeylistIntoAnswers([$intern_35, $intern_45], $intern_54);
      unflattenKeylistIntoAnswers([$intern_37, $intern_45], $intern_54);
      unflattenKeylistIntoAnswers([$intern_36, $intern_44], $intern_55);
      unflattenKeylistIntoAnswers([$intern_35, $intern_44], $intern_55);
      unflattenKeylistIntoAnswers([$intern_37, $intern_44], $intern_55);
      unflattenKeylistIntoAnswers([$intern_36, $intern_46], $intern_56);
      unflattenKeylistIntoAnswers([$intern_35, $intern_46], $intern_56);
      unflattenKeylistIntoAnswers([$intern_37, $intern_46], $intern_56);
      strongName = answers[computePropValue($intern_34)][computePropValue($intern_38)];
      initialHtml = strongName + $intern_57;
    }
     catch (e) {
      return;
    }
  }
  var onBodyDoneTimerId;
  function onBodyDone(){
    if (!bodyDone) {
      bodyDone = true;
      if (!__gwt_stylesLoaded[$intern_58]) {
        var l = $doc.createElement($intern_59);
        __gwt_stylesLoaded[$intern_58] = l;
        l.setAttribute($intern_60, $intern_61);
        l.setAttribute($intern_62, base + $intern_58);
        $doc.getElementsByTagName($intern_63)[0].appendChild(l);
      }
      maybeStartModule();
      if ($doc.removeEventListener) {
        $doc.removeEventListener($intern_64, onBodyDone, false);
      }
      if (onBodyDoneTimerId) {
        clearInterval(onBodyDoneTimerId);
      }
    }
  }

  if ($doc.addEventListener) {
    $doc.addEventListener($intern_64, function(){
      maybeInjectFrame();
      onBodyDone();
    }
    , false);
  }
  var onBodyDoneTimerId = setInterval(function(){
    if (/loaded|complete/.test($doc.readyState)) {
      maybeInjectFrame();
      onBodyDone();
    }
  }
  , 50);
  $stats && $stats({moduleName:$intern_1, sessionId:$sessionId, subSystem:$intern_2, evtGroup:$intern_3, millis:(new Date).getTime(), type:$intern_9});
  $stats && $stats({moduleName:$intern_1, sessionId:$sessionId, subSystem:$intern_2, evtGroup:$intern_48, millis:(new Date).getTime(), type:$intern_4});
  $doc.write($intern_65);
}

moddingShowcase();
