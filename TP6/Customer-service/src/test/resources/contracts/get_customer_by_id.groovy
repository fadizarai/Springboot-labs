package contracts

org.springframework.cloud.contract.spec.Contract.make {
    description "returns customer by id"

    request {
        method GET()
        urlPath("/customers/1")
    }

    response {
        status 200
        headers {
            contentType(applicationJson())
        }
        body([
                id: "1",
                name: "Nom",
                country: "Pays"
        ])
    }
}

