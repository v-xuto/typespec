package payload.multipart;

import io.clientcore.core.annotations.Metadata;
import io.clientcore.core.annotations.ServiceClient;
import io.clientcore.core.http.exceptions.HttpResponseException;
import io.clientcore.core.http.models.RequestOptions;
import io.clientcore.core.http.models.Response;
import io.clientcore.core.models.binarydata.BinaryData;
import payload.multipart.formdata.httpparts.nonstring.FloatRequest;
import payload.multipart.implementation.FormDataHttpPartsNonStringsImpl;
import payload.multipart.implementation.MultipartFormDataHelper;

/**
 * Initializes a new instance of the synchronous MultiPartClient type.
 */
@ServiceClient(builder = MultiPartClientBuilder.class)
public final class FormDataHttpPartsNonStringClient {
    @Metadata(generated = true)
    private final FormDataHttpPartsNonStringsImpl serviceClient;

    /**
     * Initializes an instance of FormDataHttpPartsNonStringClient class.
     * 
     * @param serviceClient the service client implementation.
     */
    @Metadata(generated = true)
    FormDataHttpPartsNonStringClient(FormDataHttpPartsNonStringsImpl serviceClient) {
        this.serviceClient = serviceClient;
    }

    /**
     * Test content-type: multipart/form-data for non string.
     * 
     * @param body The body parameter.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the service returns an error.
     * @return the response.
     */
    @Metadata(generated = true)
    Response<Void> floatMethodWithResponse(BinaryData body, RequestOptions requestOptions) {
        // Operation 'float' is of content-type 'multipart/form-data'. Protocol API is not usable and hence not
        // generated.
        return this.serviceClient.floatMethodWithResponse(body, requestOptions);
    }

    /**
     * Test content-type: multipart/form-data for non string.
     * 
     * @param body The body parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @Metadata(generated = true)
    public void floatMethod(FloatRequest body) {
        // Generated convenience method for floatMethodWithResponse
        RequestOptions requestOptions = new RequestOptions();
        floatMethodWithResponse(new MultipartFormDataHelper(requestOptions)
            .serializeTextField("temperature", String.valueOf(body.getTemperature()))
            .end()
            .getRequestBody(), requestOptions).getValue();
    }
}
