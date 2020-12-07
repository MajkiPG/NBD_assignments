var map = function() {
    for(var i = 0; i < this.credit.length; i++) {
        emit(this.credit[i].currency, parseFloat(this.credit[i].balance))
    }
};

var reduce = function(key, value) {
    return Array.sum(value)
};

var options = { out: "BalanceSum" };

db.collection.mapReduce(map, reduce, options);
printjson(db.BalanceSum.find({}).toArray())