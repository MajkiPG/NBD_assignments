printjson(db.ollection.insertOne({
	sex: "Male",
	first_name: "Mikolaj",
	last_name: "Nienartowicz",
	job: "IT guy",
	email: "majki@gmail.com",
	"location" : {
		city: "Sopot",
		address: {
			"streetname" : "Piekna",
			"streetnumber" : "100"
		}
	},
	description: "cheers",
	height: 186.20,
	weight: 86.00,
	birth_date: "1996-02-21T02:55:03Z",
	nationality: "Poland",
	credit: [
		{
			type: "visa",
			number: "67836483939100098699",
			currency: "PLN",
			balance: "1000000.06"
		}
	]
}))