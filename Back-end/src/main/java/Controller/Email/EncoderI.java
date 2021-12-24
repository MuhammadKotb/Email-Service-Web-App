package Controller.Email;

public interface EncoderI {
    Attachment encode(String path) throws Exception;
}
