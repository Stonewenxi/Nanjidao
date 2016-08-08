/**
 * Author: 56
 * Date:   3/9/16
 * E-Mail: mysherrymyqueen@outlook.com
 */

/**
 * 一些全局属性
 */
var current = ""; // 当前展开的标签id

/**
 * 界面打开时请求获取项目数据并进行响应设置
 */
$(function () {
    var sortId = $("#sortTitle").attr('sortId');
    $.ajax({
        url: baseUrl + '/project/findAll?sortId=' + sortId,
        method: 'get',
        success: function (data) {

            var sort = data.sort;
            var res = data.list;

            /* 修改题图区 */
            themeSet(sort, res);

            /* 动态生成页面 */
            generateProject(res);

            /* 页面点击切换事件 */
            projectClick();
        }
    })
});

/**
 * 设置题图区的项目数
 * @param sort
 * @param data 得到的json数据
 */
function themeSet(sort, data) {
    if (sort.id != 0) $("#sortTitle").text(sort.name);
    $(".themePic").find("p").text("当前共有 " + data.length + " 个项目")
}

/**
 * 动态生成Project标签
 * @param data 得到的json数据
 */
function generateProject(data) {
    var project, idName;
    for (var i = 1; i < data.length; i++) {
        project = data[i];
        idName = "project" + project.id;

        // 左边内容设置
        var sectionDiv = $(".contentDetail > #project_section").clone();
        $(sectionDiv).attr("id", idName + "Section");

        $(sectionDiv).find(".contentDetailExpanded > h1").text(project.title);
        $(sectionDiv).find(".contentDetailExpanded > h2").text(project.subTitle);
        $(sectionDiv).find(".contentDetailExpanded > p").text(project.remark);
        $(sectionDiv).find(".contentDetailExpanded > button").children(":first").text(project.interest + "人有兴趣");
        $(sectionDiv).find(".contentDetailExpanded > button").attr("id", project.id);

        $(sectionDiv).find(".contentDetailCollapsed").find("header").find(".title").text(project.title);
        $(sectionDiv).find(".contentDetailCollapsed").find("header").find(".subTitle").html("&nbsp;· " + project.subTitle);
        $(sectionDiv).find(".contentDetailCollapsed > p").text(project.interest + " 人有兴趣");

        $(".contentDetail").append($(sectionDiv));


        // 右边标题设置
        var projectDiv = $(".contentLogo > #project").clone();
        $(projectDiv).attr("id", idName);

        $(projectDiv).find(".title").text(project.title);
        $(projectDiv).find(".subTitle").text(" · " + project.subTitle);
        $(projectDiv).find(".logoPic > img").attr("src", "logo/" + project.logo);

        $(".contentLogo").append($(projectDiv));
    }

    // 设置两边第一个显示
    project = data[0];
    idName = "project" + project.id;

    var temp = ".contentDetail > #project_section";
    $(temp).find(".contentDetailExpanded > h1").text(project.title);
    $(temp).find(".contentDetailExpanded > h2").html(project.subTitle);
    $(temp).find(".contentDetailExpanded > p").text(project.remark);
    $(temp).find(".contentDetailExpanded > button").children(":first").text(project.interest + "人有兴趣");
    $(temp).find(".contentDetailExpanded > button").attr("id", project.id);
    $(temp).find(".contentDetailExpanded").css("display", "");

    $(temp).find(".contentDetailCollapsed").find("header").find(".title").text(project.title);
    $(temp).find(".contentDetailCollapsed").find("header").find(".subTitle").html("&nbsp;· " + project.subTitle);
    $(temp).find(".contentDetailCollapsed > p").text(project.interest + " 人有兴趣");
    $(temp).find(".contentDetailCollapsed").css("display", "none");

    $(temp).attr("id", idName + "Section");


    temp = ".contentLogo > #project";
    $(temp).find(".title").text(project.title);
    $(temp).find(".subTitle").text(" · " + project.subTitle);
    $(temp).find(".logoPic > img").attr("src", "logo/" + project.logo);

    $(temp).find(".logoCurrentSquare").css("visibility", "");
    $(temp).attr("id", idName);

    current = "#" + idName;

    // 给按钮设置点击事件
    $(".contentDetailExpanded > button").click(function () {
        window.location.href = baseUrl + "/details?id=" + $(this).attr("id");
    })
}

/**
 * figure 标签点击事件
 */
function projectClick() {
    $("project").click(function () {
        var temp = "#" + $(this).attr("id");

        if (temp == current) {
            return
        }

        // 收缩已经展开的
        var old = current + "Section";
        //noinspection JSValidateTypes
        $(old).children().toggle(600);
        $(current).find(".logoCurrentSquare").css('visibility', 'hidden');

        // 展开点击的
        var target = temp + "Section";
        //noinspection JSValidateTypes
        $(target).children().toggle(600);
        $(temp).find(".logoCurrentSquare").css('visibility', 'visible');

        current = temp;
    })
}

/**
 * 微信配置注入
 */
$(function () {
    $.ajax({
        url: baseUrl + '/project/share',
        type: 'post',
        data: {url: window.location.href},
        success: function (data) {
            if (typeof data == 'object') {
                wx.config({
                    debug: false,
                    appId: data.flag.appId,
                    timestamp: data.flag.timestamp,
                    nonceStr: data.flag.nonceStr,
                    signature: data.flag.signature,
                    jsApiList: ['onMenuShareTimeline']
                });

                wx.ready(function () {
                    timeLineShare()
                });

                wx.error(function (res) {
                    // alert('配置失败' + res)
                });
            }
        },
        error: function (data) {
            // alert('分享失败')
        }
    })
});

/**
 * 微信朋友圈分享相关
 */
function timeLineShare() {
    var title = "LinhuiFund";
    var link = window.location.href;
    var imgUrl = baseUrl + '/view/images/LinhuiFundLogo.png';

    wx.onMenuShareTimeline({
        title: title,
        link: link,
        imgUrl: imgUrl,
        success: function () {
            alert('你已成功分享到朋友圈')
        },
        cancel: function () {
            alert('你已取消分享')
        },
        fail: function () {
            alert('分享失败,请重新尝试')
        }
    });
}