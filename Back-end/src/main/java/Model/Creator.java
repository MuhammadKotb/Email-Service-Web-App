package Model;


import Model.ProfileBuilder.ProfileBuilder;
import Model.ProfileBuilder.ProfileBuilderI;
import Model.ProfileBuilder.ProfileDirector;
import Model.ProfileBuilder.ProfileI;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class Creator {

    private static Creator instance;

    private Creator() {}
    public static Creator getInstance(){
        if(instance == null){
            instance = new Creator();
            System.out.println("CREATED CREATOR");
        }
        return instance;
    }

    private static DataContainerI createDataContainer(String dataContainerPath, String dataContainerName) throws Exception{
        File file = new File(dataContainerPath);
        boolean createdFile = file.mkdir();
        if(createdFile){
            return new DataContainer(dataContainerPath, dataContainerName, file);
        }
        else{
            throw new Exception("COULD NOT CREATE DATA CONTAINER");
        }
    }


    public ProfileI createProfile(String dataBasePath, String encryption) throws Exception{
        ProfileBuilderI profileBuilder = new ProfileBuilder();
        ProfileDirector profileDirector = new ProfileDirector();

        profileDirector.buildProfileData(profileBuilder, encryption);
        profileDirector.buildDataContainer(profileBuilder, createDataContainer(dataBasePath.concat(encryption), encryption));

        profileDirector.buildInbox(profileBuilder, createDataContainer(dataBasePath.concat(encryption).concat("/Inbox"), "Inbox"));
        profileDirector.buildOutbox(profileBuilder, createDataContainer(dataBasePath.concat(encryption).concat("/Outbox"), "Outbox"));
        profileDirector.buildDraft(profileBuilder, createDataContainer(dataBasePath.concat(encryption).concat("/Draft"), "Draft"));
        profileDirector.buildTrash(profileBuilder, createDataContainer(dataBasePath.concat(encryption).concat("/Trash"), "Trash"));
        profileDirector.buildContacts(profileBuilder, createDataContainer(dataBasePath.concat(encryption).concat("/Contacts"), "Contacts"));

        return profileBuilder.getProfile();
    }

    public ProfileI setProfile(String dataBasePath, String encryption) throws Exception{
        ProfileBuilderI profileBuilder = new ProfileBuilder();
        ProfileDirector profileDirector = new ProfileDirector();

        profileDirector.buildProfileData(profileBuilder, encryption);

        profileDirector.buildDataContainer(profileBuilder, new DataContainer(dataBasePath.concat(encryption), encryption, new File(dataBasePath.concat(encryption))));

        profileDirector.buildInbox(profileBuilder, new DataContainer(dataBasePath.concat(encryption).concat("/Inbox"), "Inbox", new File(dataBasePath.concat(encryption).concat("/Inbox"))));
        profileDirector.buildOutbox(profileBuilder, new DataContainer(dataBasePath.concat(encryption).concat("/Outbox"), "Outbox", new File(dataBasePath.concat(encryption).concat("/Outbox"))));
        profileDirector.buildDraft(profileBuilder, new DataContainer(dataBasePath.concat(encryption).concat("/Draft"), "Draft", new File(dataBasePath.concat(encryption).concat("/Draft"))));
        profileDirector.buildTrash(profileBuilder, new DataContainer(dataBasePath.concat(encryption).concat("/Trash"), "Trash", new File(dataBasePath.concat(encryption).concat("/Trash"))));
        profileDirector.buildContacts(profileBuilder, new DataContainer(dataBasePath.concat(encryption).concat("/Contacts"), "Contacts", new File(dataBasePath.concat(encryption).concat("/Contacts"))));

        return profileBuilder.getProfile();

    }

    public void createDataFile(ProfileI profile) throws Exception{
        File file = new File(profile.getDataContainer().getDataContainerPath().concat("/PROFILE.json"));
        if(!file.createNewFile()){
            throw new Exception("COULD NOT CREATE PROFILE DATA FILE");
        }
        ObjectMapper map = new ObjectMapper();
        map.writeValue(file, profile);
    }

    public EmailI createEmailDataInbox(EmailI email, ProfileI profile, String ID) throws Exception{
        EmailI inboxEmail = new Email(email.getSubject(), email.getBody(), email.getSenderUsername(), email.getreceiverUsername(), "Inbox", email.getAttachments());
        File file = new File(profile.getInbox().getInboxDataContainer().getDataContainerPath().concat("/").concat(ID).concat(".json"));
        if(!file.createNewFile()){
            throw new Exception("COULD NOT CREATE INBOX EMAIL FILE");
        }
        inboxEmail.setEmailID(ID);
        inboxEmail.setOwner(email.getreceiverUsername());
        ObjectMapper map = new ObjectMapper();
        map.writeValue(file, inboxEmail);
        return inboxEmail;
    }
    public EmailI createEmailDataOutbox(EmailI email, ProfileI profile, String ID) throws Exception{
        EmailI outboxEmail = new Email(email.getSubject(), email.getBody(), email.getSenderUsername(), email.getreceiverUsername(), "Outbox", email.getAttachments());
        File file = new File(profile.getOutbox().getOutboxDataContainer().getDataContainerPath().concat("/").concat(ID).concat(".json"));
        if(!file.createNewFile()){
            throw new Exception("COULD NOT CREATE OUTBOX EMAIL FILE");
        }
        outboxEmail.setEmailID(ID);
        outboxEmail.setOwner(email.getSenderUsername());
        ObjectMapper map = new ObjectMapper();
        map.writeValue(file, outboxEmail);
        return outboxEmail;
    }
    public EmailI createEmailDataDraft(EmailI email, ProfileI profile, String ID) throws Exception{
        EmailI draftEmail = new Email(email.getSubject(), email.getBody(), email.getSenderUsername(), email.getreceiverUsername(), "Draft", email.getAttachments());
        File file = new File(profile.getDraft().getDraftDataContainer().getDataContainerPath().concat("/").concat(ID).concat(".json"));
        if(!file.createNewFile()){
            throw new Exception("COULD NOT CREATE TRASH EMAIL FILE");
        }
        draftEmail.setEmailID(ID);
        ObjectMapper map = new ObjectMapper();
        map.writeValue(file, draftEmail);
        return draftEmail;

    }
    public EmailI createEmailDataTrash(EmailI email, ProfileI profile, String ID) throws Exception{
        EmailI trashEmail = new Email(email.getSubject(), email.getBody(), email.getSenderUsername(), email.getreceiverUsername(), "Trash", email.getAttachments());
        File file = new File(profile.getTrash().getTrashDataContainer().getDataContainerPath().concat("/").concat(ID).concat(".json"));
        if(!file.createNewFile()){
            throw new Exception("COULD NOT CREATE TRASH EMAIL FILE");
        }
        trashEmail.setEmailID(ID);
        trashEmail.setOwner(email.getOwner());
        ObjectMapper map = new ObjectMapper();
        map.writeValue(file, trashEmail);
        return trashEmail;

    }





}
