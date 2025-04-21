package com.wasm;

import java.io.InputStream;

import com.dylibso.chicory.runtime.Instance;
import com.dylibso.chicory.wasm.Parser;
import com.dylibso.chicory.wasm.WasmModule;

public class Main {
	public static void main(String[] args) {
		// go-example
		var goInstance = loadWasmInstance("wasm-go-exam.wasm");
		var goExportFunc = goInstance.export("add");
		var goAddResult = goExportFunc.apply(1, 2)[0];
		System.out.println("Golang Result: " + goAddResult);

		// rust-example
		var rustInstance = loadWasmInstance("wasm-rust-exam.wasm");
		var rustExportFunc = rustInstance.export("add");
		var rustAddResult = rustExportFunc.apply(3, 4)[0];
		System.out.println("Rust Result: " + rustAddResult);
	}

	public static Instance loadWasmInstance(String name) {
		InputStream stream = Main.class.getClassLoader().getResourceAsStream(name);
		WasmModule module = Parser.parse(stream);
		return Instance.builder(module).build();
	}
}