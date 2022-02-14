package cc.powind.workwx.material;

public class MediaService {

    public String upload(String type, String filename, byte[] bytes) {

        /*String url = "https://qyapi.weixin.qq.com/cgi-bin/media/upload?access_token=%s&type=%s";
        String token = accessTokenService.getAccessToken(AppEnum.ADDRESS.name());
        url = String.format(url, token, type.toLowerCase());

        //设置请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("multipart/form-data"));

        //设置请求体，注意是LinkedMultiValueMap
        MultiValueMap<String, Object> form = new LinkedMultiValueMap<>();
        ByteArrayResource resource = new ByteArrayResource(bytes) {

            @Override
            public long contentLength() {
                return bytes.length;
            }

            @Override
            public String getFilename() {
                return filename;
            }
        };

        form.add("media", resource);
        form.add("filename", filename);
        form.add("filelength", bytes.length);

        //用HttpEntity封装整个请求报文
        HttpEntity<MultiValueMap<String, Object>> files = new HttpEntity<>(form, headers);

        String responseTxt = restTemplate.postForObject(url, files, String.class);

        MediaResponse response = readValue(responseTxt, MediaResponse.class);

        if (response == null || response.validate() != null) {
            throw new RuntimeException(response == null ? "企业微信接口返回为空！" : response.validate());
        }

        return response.getMediaId();*/
        return null;
    }
}
