$(function () {
    initGrid();

});

function initGrid() {
    $("#grid").jqGrid({
        height: "auto",
        url: "sys/person/list",
        mtype: "POST",
        datatype: "json",
        styleUI:"Bootstrap4",
        colModel: [
            {name: 'id', label: 'id', hidden: true, width: 40},
            {name: 'name', label: '群名片', editable: true, width: 170},
            {name: 'qq', label: 'QQ号', editable: true, width: 100},
            {name: 'battleId', label: '战网ID', editable: true, width: 180},
            {name: 'level', label: '段位', editable: true, width: 100,
                formatter:function (cellValue, options, rowObject) {
                var html = "";
                switch(cellValue) {
                    case "A":
                        html = '青铜';
                        break;
                    case "B":
                        html = '白银';
                        break;
                    case "C":
                        html = '黄金';
                        break;
                    case "D":
                        html = '白金';
                        break;
                    case "E":
                        html = '钻石';
                        break;
                    case "F":
                        html = '大师';
                        break;
                    case "G":
                        html = '宗师';
                        break;
                    default:
                        html = '';
                }
                return html;
            }
            }
        ],
        viewrecords: true,
        rownumbers: true,
        altRows: true,
        rowNum: 50,
        rowList: [20, 50, 100],
        pager: "#grid-pager",
        multiselect: false,
        sortname: 'createTime',
        sortorder: "desc",
        shrinkToFit: false,
        autoScroll: false,
        autowidth: true
    });
}

function addPerson() {
    window.location.href = "person_add.html"
}
