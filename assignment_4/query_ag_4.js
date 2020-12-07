printjson(db.collection.aggregate( [ 
    { $addFields: { bmi: { $divide: [ { $toDouble: "$weight" }, { $pow:  [ { $divide: [ { $toDouble: "$height" }, 100 ] }, 2 ] } ] } } },
    { $group: { _id: "$nationality", averageBmi: { $avg: "$bmi" }, minBmi: { $min: "$bmi" }, maxBmi: { $max: "$bmi" } } }
] ).toArray())