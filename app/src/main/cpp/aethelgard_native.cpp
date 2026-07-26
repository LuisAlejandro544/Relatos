#include <jni.h>
#include <string>
#include <android/log.h>

#define LOG_TAG "AethelgardNativeCPP"
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO, LOG_TAG, __VA_ARGS__)

extern "C" {

JNIEXPORT jstring JNICALL
Java_com_example_engine_NativeEngineBridge_nativeEvaluateEpilogueBranch(
    JNIEnv* env,
    jobject /* this */,
    jstring currentSceneId,
    jstring choiceId,
    jint gold,
    jint heroLevel
) {
    const char* cChoiceId = env->GetStringUTFChars(choiceId, nullptr);
    std::string choiceStr(cChoiceId);
    env->ReleaseStringUTFChars(choiceId, cChoiceId);

    std::string targetScene = "SCENE_VICTORY_DEMO";

    if (choiceStr == "choice_epilogue_honor") {
        targetScene = "SCENE_EPILOGUE_HONOR_OAKHAVEN";
    } else if (choiceStr == "choice_epilogue_mercenary") {
        targetScene = "SCENE_EPILOGUE_MERCENARY_GUILD";
    } else if (choiceStr == "choice_epilogue_outlaw") {
        targetScene = "SCENE_EPILOGUE_OUTLAW_ROAD";
    } else if (choiceStr == "choice_epilogue_shadows") {
        targetScene = "SCENE_EPILOGUE_SHADOW_PACT";
    }

    LOGI("Evaluando rama de epílogo en C++ Core: %s", targetScene.c_str());
    return env->NewStringUTF(targetScene.c_str());
}

JNIEXPORT jint JNICALL
Java_com_example_engine_NativeEngineBridge_nativeCalculateCombat(
    JNIEnv* /* env */,
    jobject /* this */,
    jint baseDamage,
    jint defense,
    jlong seed
) {
    int variance = static_cast<int>(seed % 7);
    int rawDamage = baseDamage + variance - (defense / 2);
    return rawDamage > 1 ? rawDamage : 1;
}

JNIEXPORT jstring JNICALL
Java_com_example_engine_NativeEngineBridge_nativeGetEngineStatus(
    JNIEnv* env,
    jobject /* this */
) {
    std::string status = "Rust Core v1.78 + C++20 Performance Engine [JNI Active]";
    return env->NewStringUTF(status.c_str());
}

} // extern "C"
