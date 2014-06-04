# Cordova MultiImageSelector Plugin

## Description

Cordova Android Plugin for select multiple images from Gallery. This plugin developed from existing 
Android open source library **[MultipleImagePick](https://github.com/luminousman/MultipleImagePick)**. Also this plugin uses **[Universal image loader](https://github.com/nostra13/Android-Universal-Image-Loader)** library for asynchronous loading and caching. 

## Usage
```javascript
window.plugins.multiImageSelector.getPictures(
    function(results) {
        for (var i = 0; i < results.paths.length; i++) {
            alert('Image URI: ' + results.paths[i]);
        }
    }, function (error) {
        alert('Error: ' + error);
    }, {
        type: "multiple",
        limit: 10,
        cancelButtonText: "取消",
        okButtonText: "确定",
        titleText: "选择图片",
        errorMessageText: "选择图片的个数超过了上限~！"
    }
);
```