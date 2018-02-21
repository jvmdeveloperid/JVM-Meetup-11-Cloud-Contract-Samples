package contracts.com.bertzzie.tiket.api

import org.springframework.cloud.contract.spec.Contract

/**
 * [Documentation Here]
 *
 * @author Alex Xandra Albert Sim
 */
Contract.make {
    description("Get available languages")
    request {
        method GET()
        urlPath('/languages') {
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
                [code: 'en', name: 'English'],
                [code: 'id', name: 'Indonesian']
        ])
    }
}
