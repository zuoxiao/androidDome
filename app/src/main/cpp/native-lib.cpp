#include <jni.h>
#include <string>
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <string.h>
#include <sys/mman.h>
#include <fcntl.h>
extern "C"{
char * ptr = NULL;
}
extern "C" JNIEXPORT void JNICALL
Java_com_itfitness_mmapobserve_MainActivity_mmapOpen(
        JNIEnv* env,
        jobject /* this */,
        jstring path) {
    const char *file_path = env->GetStringUTFChars(path,0);
    int fd = open(file_path, O_RDWR|O_CREAT|O_TRUNC,0644); //打开本地磁盘中的文件(如果没有就创建一个), 获取fd,0644是可读写的意思
    if(fd == -1) {
        perror("open error");
    }
    //改变文件的大小（否则大小对应不起来就报错）
    ftruncate(fd,100);
    ptr = (char*)mmap(NULL, 100, PROT_READ | PROT_WRITE, MAP_SHARED, fd, 0);
    if(ptr == MAP_FAILED) {
        perror("mmap error");
    }
    //关闭文件句柄
    close(fd);
}
extern "C"
JNIEXPORT void JNICALL
Java_com_itfitness_mmapobserve_MainActivity_mmapClose(JNIEnv *env, jobject thiz) {
    if(ptr != NULL){
        // 释放内存映射区
        int ret = munmap(ptr, 100);
        if(ret == -1) {
            perror("munmap error");
        }
    }
}

extern "C"
JNIEXPORT void JNICALL
Java_com_itfitness_mmapobserve_MainActivity_mmapSetEmpty(JNIEnv *env, jobject thiz) {
    if(ptr != NULL){
        // 将共享映射区置空
        memset(ptr, 0, 100);
    }
}

extern "C" JNIEXPORT jstring JNICALL
Java_com_itfitness_mmapobserve_MainActivity_observe(
        JNIEnv* env,
        jobject /* this */,
        jstring defaultVal) {
    if(ptr != NULL){
        return env->NewStringUTF(ptr);
    }
    return defaultVal;
}