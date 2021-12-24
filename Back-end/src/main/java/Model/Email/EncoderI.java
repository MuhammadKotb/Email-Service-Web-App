package Model.Email;

import Model.Email.Attachment;

public interface EncoderI {
    Attachment encode(String path) throws Exception;
}
