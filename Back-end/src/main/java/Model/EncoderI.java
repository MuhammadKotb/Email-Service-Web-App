package Model;

import java.io.File;

public interface EncoderI {
    Attachment encode(String path) throws Exception;
}
