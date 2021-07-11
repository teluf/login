package com.teluf.login;

public class EncryptionHandler {
	protected static String encrypt(String x) {
		String encryptedString = "";
		for(int i  =  0; i < x.length(); i++) {
			char currentChar = x.charAt(i);
			
			switch(currentChar) {
				case 'a':  
	                encryptedString = encryptedString + "{";  
	                break;  
	            case 'b':  
	                encryptedString = encryptedString + "}";  
	                break;  
	            case 'c':  
	                encryptedString = encryptedString + "#";  
	                break;  
	            case 'd':  
	                encryptedString = encryptedString + "~";  
	                break;  
	            case 'e':  
	                encryptedString = encryptedString + "+";  
	                break;  
	            case 'f':  
	                encryptedString = encryptedString + "-";  
	                break;  
	            case 'g':  
	                encryptedString = encryptedString + "*";  
	                break;  
	            case 'h':  
	                encryptedString = encryptedString + "@";  
	                break;  
	            case 'i':  
	                encryptedString = encryptedString + "/";  
	                break;  
	            case 'j':  
	                encryptedString = encryptedString + "\\";  
	                break;  
	            case 'k':  
	                encryptedString = encryptedString + "?";  
	                break;  
	            case 'l':  
	                encryptedString = encryptedString + "$";  
	                break;  
	            case 'm':  
	                encryptedString = encryptedString + "!";  
	                break;  
	            case 'n':  
	                encryptedString = encryptedString + "^";  
	                break;  
	            case 'o':  
	                encryptedString = encryptedString + "(";  
	                break;  
	            case 'p':  
	                encryptedString = encryptedString + ")";  
	                break;  
	            case 'q':  
	                encryptedString = encryptedString + "<";  
	                break;  
	            case 'r':  
	                encryptedString = encryptedString + ">";  
	                break;  
	            case 's' :  
	                encryptedString = encryptedString + "=";  
	                break;  
	            case 't':  
	                encryptedString = encryptedString + ";";  
	                break;  
	            case 'u':  
	                encryptedString = encryptedString + ",";  
	                break;  
	            case 'v' :  
	                encryptedString = encryptedString + "_";  
	                break;  
	            case 'w':  
	                encryptedString = encryptedString + "[";  
	                break;  
	            case 'x' :  
	                encryptedString = encryptedString + "]";  
	                break;  
	            case 'y':  
	                encryptedString = encryptedString + ":";  
	                break;  
	            case 'z' :  
	                encryptedString = encryptedString + "\"";  
	                break;  
	            case ' ' :  
	                encryptedString = encryptedString + " ";  
	                break;  
	            case '.':  
	                encryptedString = encryptedString + '3';  
	                break;  
	            case ',':  
	                encryptedString = encryptedString + "1";  
	                break;  
	            case '(':  
	                encryptedString = encryptedString + '4';  
	                break;  
	            case '\"':  
	                encryptedString = encryptedString + '5';  
	                break;  
	            case ')' :  
	                encryptedString = encryptedString + "7";  
	                break;  
	            case '?' :  
	                encryptedString = encryptedString + "2";  
	                break;  
	            case '!':  
	                encryptedString = encryptedString + "8";  
	                break;  
	            case '-' :  
	                encryptedString = encryptedString + "6";  
	                break;  
	            case '%' :  
	                encryptedString = encryptedString + "9";  
	                break;  
	            case '1':  
	                encryptedString = encryptedString + "r";  
	                break;  
	            case '2':  
	                encryptedString = encryptedString + "k";  
	                break;  
	            case '3':  
	                encryptedString = encryptedString + "b";  
	                break;  
	            case '4':  
	                encryptedString = encryptedString + "e";  
	                break;  
	            case '5':  
	                encryptedString = encryptedString + "q";  
	                break;  
	            case '6':  
	                encryptedString = encryptedString + "h";  
	                break;  
	            case '7':  
	                encryptedString = encryptedString + "u";  
	                break;  
	            case '8' :  
	                encryptedString = encryptedString + "y";  
	                break;  
	            case '9':  
	                encryptedString = encryptedString + "w";  
	                break;  
	            case '0':  
	                encryptedString = encryptedString + "z";  
	                break;  
	             default:  
	                encryptedString = encryptedString + "0";
	                break;  
			}
		}
		return encryptedString;
	}
	
	protected static String decrypt(String x) {
		String decryptedString = "";
		for(int i  =  0; i < x.length(); i++) {
			char currentChar = x.charAt(i);
			
			switch(currentChar) {
				case '{':  
		            decryptedString = decryptedString+"a";  
		            break;  
		        case '}':  
		            decryptedString = decryptedString+"b";  
		            break;  
		        case '#': 
		            decryptedString = decryptedString+"c";  
		            break;  
		        case '~':  
		            decryptedString = decryptedString+"d";  
		            break;  
		        case '+':  
		            decryptedString = decryptedString+"e";  
		            break;  
		        case '-':  
		            decryptedString = decryptedString+"f";  
		            break;  
		        case '*':  
		            decryptedString = decryptedString+"g";  
		            break;  
		        case '@':  
		            decryptedString = decryptedString+"h";  
		            break;  
		        case '/':  
		            decryptedString = decryptedString+"i";  
		            break;  
		        case '\\':  
		            decryptedString = decryptedString+"j";  
		            break;  
		        case '?':  
		            decryptedString = decryptedString+"k";  
		            break;  
		        case '$':  
		            decryptedString = decryptedString+"l";  
		            break;  
		        case '!':  
		            decryptedString = decryptedString+"m";  
		            break;  
		        case '^':  
		            decryptedString = decryptedString+"n";  
		            break;  
		        case '(':  
		            decryptedString = decryptedString+"o";  
		            break;  
		        case ')':  
		            decryptedString = decryptedString+"p";  
		            break;  
		        case '<':  
		            decryptedString = decryptedString+"q";  
		            break;  
		        case '>':  
		            decryptedString = decryptedString+"r";  
		            break;  
		        case '=' :  
		            decryptedString = decryptedString+"s";  
		            break;  
		        case ';':  
		            decryptedString = decryptedString+"t";  
		            break;  
		        case ',':  
		            decryptedString = decryptedString+"u";  
		            break;  
		        case '_' :  
		            decryptedString = decryptedString+"v";  
		            break;  
		        case '[':  
		            decryptedString = decryptedString+"w";  
		            break;  
		        case ']' :  
		            decryptedString = decryptedString+"x";  
		            break;  
		        case ':':  
		            decryptedString = decryptedString+"y";  
		            break;  
		        case '\"' :  
		            decryptedString = decryptedString+"z";  
		            break;       
		        case '1':  
		            decryptedString = decryptedString+"r";  
		            break;  
		        case '2':  
		            decryptedString = decryptedString+"k";  
		            break;  
		        case '3':  
		            decryptedString = decryptedString+"b";  
		            break;  
		        case '4':  
		            decryptedString = decryptedString+"e";  
		            break;  
		        case '5':  
		            decryptedString = decryptedString+"q";  
		            break;  
		        case '6':  
		            decryptedString = decryptedString+"h";  
		            break;  
		        case '7':  
		            decryptedString = decryptedString+"u";  
		            break;  
		        case '8' :  
		            decryptedString = decryptedString+"y";  
		            break;  
		        case '9':  
		            decryptedString = decryptedString+"w";  
		            break;  
		        case '0':  
		            decryptedString = decryptedString+"z";  
		            break;  
		        default:
		            decryptedString = decryptedString+"0";  
		            break;
			}
		}
		return decryptedString;
	}
}