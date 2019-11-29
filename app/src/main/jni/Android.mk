LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)
LOCAL_MODULE    := libADrvLicCardOCR
LOCAL_SRC_FILES := libADrvLicCardOCR.so
include $(PREBUILT_SHARED_LIBRARY)