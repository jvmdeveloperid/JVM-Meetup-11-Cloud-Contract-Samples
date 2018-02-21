package contracts.com.bertzzie.tiket.api

import org.springframework.cloud.contract.spec.Contract

/**
 * [Documentation Here]
 *
 * @author Alex Xandra Albert Sim
 */
Contract.make {
    description("Get available currencies")
    request {
        method GET()
        urlPath('/currencies') {
            queryParameters {
                parameter 'output': optional('json')
            }
        }
        headers {
            accept(applicationJson())
        }
    }

    response {
        status 200
        headers {
            contentType(applicationJson())
        }
        body([
                [code: 'IDR', language: 'id', name: 'IDR - Rupiah Indonesia'],
                [code: 'USD', language: 'en-us', name: 'USD - Dolar Amerika']
        ])
    }
}
