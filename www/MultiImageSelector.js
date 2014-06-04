var MultiImageSelector = function() {
};

MultiImageSelector.prototype.getPictures = function(success, fail, options) {
    if (!options) {
        options = {};
    }
    
    var params = {
        type: options.type ? options.type : "multiple",
        limit: options.limit ? options.limit : 15,
        cancelButtonText: options.cancelButtonText ? options.cancelButtonText : "Cancel",
        okButtonText: options.okButtonText ? options.okButtonText : "Done",
        titleText: options.titleText ? options.titleText : "Gallery",
        errorMessageText: options.errorMessageText ? options.errorMessageText : "Max limit reached!"
    };

    return cordova.exec(success, fail, "MultiImageSelector", "getPictures", [params]);
};

module.exports = new MultiImageSelector();
