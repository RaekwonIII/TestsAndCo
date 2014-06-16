package com.Massimo.Matillion.Test;

import java.io.IOException;

import org.json.JSONException;

public class Main {

	public static void main(String[] args) {

		Test3 t3 = new Test3();
		
		try {
			t3.distanceCalc();
		} catch (IOException e) {
//			e.printStackTrace();
			System.err.println(e.getMessage());
		} catch (JSONException e) {
//			e.printStackTrace();
			System.err.println(e.getMessage());
		}
	}

}
