//! Motor de Lógica Determinista e Inmutabilidad de Aethelgard en Rust
//!
//! Este módulo proporciona validación inmutable de elecciones del epílogo
//! y cálculo determinista de semillas de RNG para tiradas de daño.

use jni::objects::{JClass, JString};
use jni::sys::{jint, jlong, jstring};
use jni::JNIEnv;

#[no_mangle]
pub extern "system" fn Java_com_example_engine_NativeEngineBridge_nativeEvaluateEpilogueBranchRust(
    mut env: JNIEnv,
    _class: JClass,
    _current_scene: JString,
    choice_id: JString,
    _gold: jint,
    _hero_level: jint,
) -> jstring {
    let choice_str: String = env
        .get_string(&choice_id)
        .expect("Error al leer choice_id en Rust")
        .into();

    let target_scene = match choice_str.as_str() {
        "choice_epilogue_honor" => "SCENE_EPILOGUE_HONOR_OAKHAVEN",
        "choice_epilogue_mercenary" => "SCENE_EPILOGUE_MERCENARY_GUILD",
        "choice_epilogue_outlaw" => "SCENE_EPILOGUE_OUTLAW_ROAD",
        "choice_epilogue_shadows" => "SCENE_EPILOGUE_SHADOW_PACT",
        _ => "SCENE_VICTORY_DEMO",
    };

    let output = env
        .new_string(target_scene)
        .expect("Error al crear JString en Rust");
    output.into_raw()
}

#[no_mangle]
pub extern "system" fn Java_com_example_engine_NativeEngineBridge_nativeCalculateCombatRust(
    _env: JNIEnv,
    _class: JClass,
    base_damage: jint,
    defense: jint,
    seed: jlong,
) -> jint {
    let variance = (seed % 7) as i32;
    let raw_damage = base_damage + variance - (defense / 2);
    if raw_damage > 1 {
        raw_damage
    } else {
        1
    }
}
