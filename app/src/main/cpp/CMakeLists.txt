# CMakeLists.txt para Aethelgard Native Core Engine (C++20 & Rust Bridge)
cmake_minimum_required(VERSION 3.22.1)

project("aethelgard_native")

# Estándar de C++20
set(CMAKE_CXX_STANDARD 20)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

# Directorio de fuentes nativas C++
add_library(
    aethelgard_native
    SHARED
    aethelgard_native.cpp
)

# Inclusión de librerías del NDK de Android (log de Android)
find_library(
    log-lib
    log
)

target_link_libraries(
    aethelgard_native
    ${log-lib}
)
