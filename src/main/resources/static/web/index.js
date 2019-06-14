var app = new Vue({
    el: '#app',
    data: function() {
        return {
            table_info: [],
            persist_info: []
        }
    },
    created(){
        fetch('/web/testJson.json')
            .then(response => response.json())
            .then(json => {
                this.table_info = JSON.parse(JSON.stringify(json));
                this.persist_info = JSON.parse(JSON.stringify(json));
            })

    },
    methods: {
        greet: function (key) {
            // use this to refer to present vue instance
            userAction(key);
        }
    }
});