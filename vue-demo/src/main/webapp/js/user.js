const app = new Vue({
    el: '#app',
    data: {
        user: {id: "", name: "", age: "", birthday: "", phone: "", bwh: "", address: "", status: ""},
        list: []
    },
    methods: {
        findAll: function () { //加载页面查看所有用户处理
            let nowThis = this; //获取vue对象
            axios.get('/user/findAll')
                .then(function (response) {
                    // 请求 success
                    nowThis.list = response.data; //将axios对象中的数据赋值给vue对象的list
                })
                .catch(function (error) {
                    // 请求 error
                    console.log("请求错误");
                })
        },
        findById: function (uid) { //点击查询用户处理
            let nowThis = this; //获取vue对象
            axios.get('/user/findById', {
                params: {
                    id: uid //将传入的uid赋值给名为id 的键
                }
            })
                .then(function (response) {
                    // 请求 success
                    nowThis.user = response.data; //将axios对象中的数据赋值给vue对象的user
                    $("#myModal").modal("show"); //用户数据查询成功显示修改模块
                })
                .catch(function (error) {
                    // 请求 error
                    console.log("请求错误");
                })
        },
        update: function () { //更新用户数据处理
            let nowThis = this; //获取vue对象
            axios.post('/user/update', nowThis.user) //post方式提交数据为json格式
                .then(function () {
                    nowThis.findAll(); //更新用户数据后再次查询数据进行展示
                })
                .catch(function () {
                    // 请求 error
                    console.log("请求错误");
                });
        }
    },
    created() {
        this.findAll(); //页面加载完执行findAll方法
    }
});