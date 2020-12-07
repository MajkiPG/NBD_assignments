var map = function() {
    if (this.nationality != "Poland" && this.sex != "Female")
        return;
    for (var i = 0; i < this.credit.length; i++) {
        emit(this.credit[i].currency, {balance: parseFloat(this.credit[i].balance), count: 0 });
    }
};

var reduce = function(key, value) {
    var reducedValue = { balance: 0, count: value.length }
    for (var i = 0; i < value.length; i++) {
        reducedValue.balance += value[i].balance;
    }
    return reducedValue;
};

function finalize(key, value) {
    return { moneyLeft: value.balance, averageBalance: value.balance/value.count };
}

var options = { out: "BalanceSumAverage", finalize: finalize };

db.collection.mapReduce(map, reduce, options);
printjson(db.BalanceSumAverage.find({}).toArray()); 