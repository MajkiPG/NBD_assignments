printjson(db.collection.aggregate( [
    { $match: { nationality: "Poland" } },
    { $match: { sex: "Female" } },
    { $unwind: "$credit" },
    { $group: { _id: "$credit.currency", moneyLeft: { $sum: { $toDouble: "$credit.balance" } }, averageBalance: { $avg: { $toDouble: "$credit.balance" } } } } 
] ).toArray())