package payload.multipart;

import io.clientcore.core.annotations.Metadata;
import io.clientcore.core.annotations.ServiceClient;
import io.clientcore.core.http.exceptions.HttpResponseException;
import io.clientcore.core.http.models.RequestOptions;
import io.clientcore.core.http.models.Response;
import io.clientcore.core.models.binarydata.BinaryData;
import java.util.stream.Collectors;
import payload.multipart.implementation.FormDataHttpPartsImpl;
import payload.multipart.implementation.MultipartFormDataHelper;

/**
 * Initializes a new instance of the synchronous MultiPartClient type.
 */
@ServiceClient(builder = MultiPartClientBuilder.class)
public final class FormDataHttpPartsClient {
    @Metadata(generated = true)
    private final FormDataHttpPartsImpl serviceClient;

    /**
     * Initializes an instance of FormDataHttpPartsClient class.
     * 
     * @param serviceClient the service client implementation.
     */
    @Metadata(generated = true)
    FormDataHttpPartsClient(FormDataHttpPartsImpl serviceClient) {
        this.serviceClient = serviceClient;
    }

    /**
     * Test content-type: multipart/form-data for mixed scenarios.
     * 
     * @param body The body parameter.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the service returns an error.
     * @return the response.
     */
    @Metadata(generated = true)
    Response<Void> jsonArrayAndFileArrayWithResponse(BinaryData body, RequestOptions requestOptions) {
        // Operation 'jsonArrayAndFileArray' is of content-type 'multipart/form-data'. Protocol API is not usable and
        // hence not generated.
        return this.serviceClient.jsonArrayAndFileArrayWithResponse(body, requestOptions);
    }

    /**
     * Test content-type: multipart/form-data for mixed scenarios.
     * 
     * @param body The body parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the service returns an error.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @Metadata(generated = true)
    public void jsonArrayAndFileArray(ComplexHttpPartsModelRequest body) {
        // Generated convenience method for jsonArrayAndFileArrayWithResponse
        RequestOptions requestOptions = new RequestOptions();
        jsonArrayAndFileArrayWithResponse(
            new MultipartFormDataHelper(requestOptions).serializeTextField("id", body.getId())
                .serializeJsonField("address", body.getAddress())
                .serializeFileField("profileImage", body.getProfileImage().getContent(),
                    body.getProfileImage().getContentType(), body.getProfileImage().getFilename())
                .serializeJsonField("previousAddresses", body.getPreviousAddresses())
                .serializeFileFields("pictures",
                    body.getPictures().stream().map(FileRequiredMetaData::getContent).collect(Collectors.toList()),
                    body.getPictures().stream().map(FileRequiredMetaData::getContentType).collect(Collectors.toList()),
                    body.getPictures().stream().map(FileRequiredMetaData::getFilename).collect(Collectors.toList()))
                .end()
                .getRequestBody(),
            requestOptions).getValue();
    }
}
