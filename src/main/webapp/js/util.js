/**
 * Created by shuqi on 3/16/16.
 */
/**
 * 检测是否符合手机号码
 */
function isPhoneNumber(string) {
    var reg = new RegExp('^1[0-9]{10}');
    return reg.test(string);
}

/**
 * 获取url中的参数
 * @param name 参数名
 */
function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg);  //匹配目标参数
    if (r != null) return unescape(r[2]);
    return null; //返回参数值
}

/**
 * Base64图转file
 * @param urlData Base64图
 * @returns {*}
 */
function convertBase64UrlToBlob(urlData) {
    var bytes = window.atob(urlData.split(',')[1]);        //去掉url的头，并转换为byte

    //处理异常,将ascii码小于0的转换为大于0
    var ab = new ArrayBuffer(bytes.length);
    var ia = new Uint8Array(ab);
    for (var i = 0; i < bytes.length; i++) {
        ia[i] = bytes.charCodeAt(i);
    }

    return new Blob([ab], {type: 'image/png'});
}