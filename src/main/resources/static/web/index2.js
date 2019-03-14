var brokenApp = new Vue({
    el: '#brokenApp',
    data: {
        table_info: []
    },
    created(){
        fetch('/web/testJson.json')
            .then(response => response.json())
            .then(json => {
                this.table_info = json
            })

        //console.log("is it created? => ", this.table_info.length);
    },
    methods: {
        greet: function (key) {
            // use this to refer to present vue instance
            //alert(key);
            brokenAction(key);
        }
    }
});