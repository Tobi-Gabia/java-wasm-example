# Java WebAssembly Example

[chicory](https://chicory.dev/)를 사용하여 java로 간단한 wasm 모듈을 실행하는 예제입니다.

- golang wasm module code
```golang
package main

func main() {}

//export add
func add(x int, y int) int {
	return x + y
}
```

- rust wasm module code
```rust
#[unsafe(no_mangle)]
pub extern "C" fn add(x: i32, y: i32) -> i32 {
    x + y
}
```