var map = function() {
    emit(this.sex, { sumWeight: parseFloat(this.weight), sumHeight: parseFloat(this.height), count: 0});
};

var reduce = function(key, value) {
    reducedValue = { sumWeight: 0, sumHeight: 0, count: value.length };
    for (var i = 0; i < value.length; i++) {
        reducedValue.sumWeight += value[i].sumWeight;
        reducedValue.sumHeight += value[i].sumHeight;
    }
    return reducedValue;
};

function finalize(key, value) {
    return { averageWeight: value.sumWeight/value.count, averageHeight: value.sumHeight/value.count };
}

var options = { out: "WeightHeightAverages", finalize: finalize };

db.collection.mapReduce(map, reduce, options);
printjson(db.WeightHeightAverages.find({}).toArray())