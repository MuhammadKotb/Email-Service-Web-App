package Model.Email;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class Encoder implements EncoderI {

    @Override
    public Attachment encode(String path) throws Exception {
        byte[] encoded = Base64.getEncoder().encode(Files.readAllBytes(Paths.get(path)));
        return new Attachment(new String(encoded, StandardCharsets.UTF_8), path.substring(path.lastIndexOf(".") + 1), path.substring(path.lastIndexOf("/") + 1, path.lastIndexOf(".")));
    }
}
