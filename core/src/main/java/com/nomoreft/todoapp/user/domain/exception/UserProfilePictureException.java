package com.nomoreft.todoapp.user.domain.exception;

public class UserProfilePictureException extends UserException{

    public UserProfilePictureException(String format, Object... args) {
        super(format, args);
    }

    public UserProfilePictureException(String message, Throwable cause) {
        super(message, cause);
    }

    public static class UserProfilePictureSaveException extends UserProfilePictureException {

        public UserProfilePictureSaveException(String message) {
            super(message);
        }

        public UserProfilePictureSaveException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static class UserProfilePictureLoadFailedException extends UserProfilePictureException {

        public UserProfilePictureLoadFailedException(String message) {
            super(message);
        }

        public UserProfilePictureLoadFailedException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
