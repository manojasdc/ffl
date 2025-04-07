package com.BisagN.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;

import org.apache.commons.codec.DecoderException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import com.itextpdf.text.pdf.codec.Base64.InputStream;

public class ImageValidationController {

	public String checkFileFormats(MultipartFile fileDoc, String filename, String documenttype)
			throws IOException, DecoderException {
		String message = "Success";
		String contenttype = fileDoc.getContentType();
		int filesize = fileDoc.getBytes().length;
		boolean checkempty = false, checkextension = false, checkMaxfilesize = true;

		ArrayList<String> contentlist = new ArrayList<>();
		ArrayList<String> extensionList = new ArrayList<>();
		if (documenttype.equalsIgnoreCase("image")) {
			String extension = "";
			int a = filename.lastIndexOf('.');
			if (a >= 0) {
				extension = filename.substring(a + 1);
			}
			extensionList.add("JPG");
			extensionList.add("PNG");
			extensionList.add("JPEG");

			contentlist.add("image/jpeg");
			contentlist.add("image/png");
			contentlist.add("image/jpg");

			if (!extensionList.contains(extension.toUpperCase())) {
				message = "Only *.JPG/PNG/JPEG file is allow to upload";
			} else if (!contentlist.contains(contenttype)) {
				message = "Only *.JPG/PNG/JPEG file is allow to upload";
			} else if (filesize == 0) {
				message = "Please do not attach empty file";
			} else if (filesize > 2097152) {
				message = "Please Upload Maximum 2 MB file";
			}

			CheckFileFormatValidation checkFileFormatValidation = new CheckFileFormatValidation();
			if (checkFileFormatValidation.check_JPEG_File(fileDoc.getBytes())
					|| checkFileFormatValidation.check_PNG_File(fileDoc.getBytes())) {

			} else {
				message = "Only *.JPG/PNG/JPEG file is allow to upload";
			}

			if (filename.indexOf('.', filename.indexOf('.') + 1) != -1) {
				message = "FileName is InValid";
			}

		}
		if (documenttype.equalsIgnoreCase("video")) {
			String extension = "";
			int a = filename.lastIndexOf('.');
			if (a >= 0) {
				extension = filename.substring(a + 1);
			}
			extensionList.add("MP4");
			

			contentlist.add("video/mp4");
			
			if (!extensionList.contains(extension.toUpperCase())) {
				message = "Only *.MP4 file is allow to upload";
			} else if (!contentlist.contains(contenttype)) {
				message = "Only *.MP4 file is allow to upload";
			} else if (filesize == 0) {
				message = "Please do not attach empty file";
			} else if (filesize > 2097152) {
				message = "Please Upload Maximum 2 MB file";
			}

			CheckFileFormatValidation checkFileFormatValidation = new CheckFileFormatValidation();
			if (checkFileFormatValidation.check_MP4_File(fileDoc.getBytes())) {

			} else {
				message = "Only *.MP4 file is allow to upload";
			}

			if (filename.indexOf('.', filename.indexOf('.') + 1) != -1) {
				message = "FileName is InValid";
			}

		}
		if (documenttype.equalsIgnoreCase("pdf")) {
			extensionList.add("PDF");
			extensionList.add("JPG");
			extensionList.add("PNG");
			extensionList.add("JPEG");
			contentlist.add("image/jpeg");
			contentlist.add("image/png");
			contentlist.add("image/jpg");
			contentlist.add("application/pdf");
			String extension = "";
			int a = filename.lastIndexOf('.');
			if (a >= 0) {
				extension = filename.substring(a + 1);
			}

			if (!extensionList.contains(extension.toUpperCase())) {
				message = "Only *.PDF file is accepted";
			} else if (!contentlist.contains(contenttype)) {
				message = "Only *.PDF file is accepted";
			} else if (filesize == 0) {
				message = "Please do not attach empty document";
			} else if (filesize > 2097152) {
				message = "Please Upload document upto Maximum 2 MB size";
			}

			CheckFileFormatValidation checkFileFormatValidation = new CheckFileFormatValidation();
			if (checkFileFormatValidation.check_PDF_File(fileDoc.getBytes())) {

			} else {
				message = "Only *.PDF file is accepted";
			}
			if (filename.indexOf('.', filename.indexOf('.') + 1) != -1) {
				message = "FileName is InValid";
			}

		}
		if (documenttype.equalsIgnoreCase("xls")) {
			extensionList.add("XLS");

			contentlist.add("application/xls");

			contentlist.add("application/octet-stream");
			contentlist.add("application/excel");
			contentlist.add("application/vnd.ms-excel");
			contentlist.add("application/x-excel");
			contentlist.add("application/x-msexcel");
			String extension = "";
			int a = filename.lastIndexOf('.');
			if (a >= 0) {
				extension = filename.substring(a + 1);
			}

			if (!extensionList.contains(extension.toUpperCase())) {
				message = "Only XLS file is accepted";
			} else if (!contentlist.contains(contenttype)) {
				message = "Only XLS file is accepted";
			} else if (filesize == 0) {
				message = "Please do not attach empty document";
			} else if (filesize > 2097152) {
				message = "Please Upload document upto Maximum 2 MB size.";
			}

		}

		return message;
	}
	
	
	public String checkFileFormatsForAllowImagePDFVideo(MultipartFile fileDoc, String filename)
			throws IOException, DecoderException {
		String message = "Success";
		String contenttype = fileDoc.getContentType();
		int filesize = fileDoc.getBytes().length;
		boolean checkempty = false, checkextension = false, checkMaxfilesize = true;

		ArrayList<String> contentlist = new ArrayList<>();
		ArrayList<String> extensionList = new ArrayList<>();
	
			String extension = "";
			int a = filename.lastIndexOf('.');
			if (a >= 0) {
				extension = filename.substring(a + 1);
			}
			
			if (extension.toUpperCase().equalsIgnoreCase("JPG") || extension.toUpperCase().equalsIgnoreCase("PNG")  ||extension.toUpperCase().equalsIgnoreCase("JPEG") ) {
			extensionList.add("JPG");
			extensionList.add("PNG");
			extensionList.add("JPEG");

			contentlist.add("image/jpeg");
			contentlist.add("image/png");
			contentlist.add("image/jpg");

			if (!extensionList.contains(extension.toUpperCase())) {
				message = "Only *.JPG/PNG/JPEG file is allow to upload";
			} else if (!contentlist.contains(contenttype)) {
				message = "Only *.JPG/PNG/JPEG file is allow to upload";
			} else if (filesize == 0) {
				message = "Please do not attach empty file";
			} else if (filesize > 2097152) {
				message = "Please Upload Maximum 2 MB file";
			}

			CheckFileFormatValidation checkFileFormatValidation = new CheckFileFormatValidation();
			if (checkFileFormatValidation.check_JPEG_File(fileDoc.getBytes())
					|| checkFileFormatValidation.check_PNG_File(fileDoc.getBytes())) {

			} else {
				message = "Only *.JPG/PNG/JPEG file is allow to upload";
			}

			if (filename.indexOf('.', filename.indexOf('.') + 1) != -1) {
				message = "FileName is InValid";
			}

		}
		
			else if (extension.toUpperCase().equalsIgnoreCase("MP4")  ) {
			extensionList.add("MP4");
			

			contentlist.add("video/mp4");
			
			if (!extensionList.contains(extension.toUpperCase())) {
				message = "Only *.MP4 file is allow to upload";
			} else if (!contentlist.contains(contenttype)) {
				message = "Only *.MP4 file is allow to upload";
			} else if (filesize == 0) {
				message = "Please do not attach empty file";
			} else if (filesize > 2097152) {
				message = "Please Upload Maximum 2 MB file";
			}

			CheckFileFormatValidation checkFileFormatValidation = new CheckFileFormatValidation();
			if (checkFileFormatValidation.check_MP4_File(fileDoc.getBytes())) {

			} else {
				message = "Only *.MP4 file is allow to upload";
			}

			if (filename.indexOf('.', filename.indexOf('.') + 1) != -1) {
				message = "FileName is InValid";
			}

		}
			else if (extension.toUpperCase().equalsIgnoreCase("PDF")  ) {
			extensionList.add("PDF");
			extensionList.add("JPG");
			extensionList.add("PNG");
			extensionList.add("JPEG");
			contentlist.add("image/jpeg");
			contentlist.add("image/png");
			contentlist.add("image/jpg");
			contentlist.add("application/pdf");
			
			if (!extensionList.contains(extension.toUpperCase())) {
				message = "Only *.PDF file is accepted";
			} else if (!contentlist.contains(contenttype)) {
				message = "Only *.PDF file is accepted";
			} else if (filesize == 0) {
				message = "Please do not attach empty document";
			} else if (filesize > 2097152) {
				message = "Please Upload document upto Maximum 2 MB size";
			}

			CheckFileFormatValidation checkFileFormatValidation = new CheckFileFormatValidation();
			if (checkFileFormatValidation.check_PDF_File(fileDoc.getBytes())) {

			} else {
				message = "Only *.PDF file is accepted";
			}
			if (filename.indexOf('.', filename.indexOf('.') + 1) != -1) {
				message = "FileName is InValid";
			}

		}else {
			
			message = "Only JPG/PDF/mp4 Files are allowed";
		}
		

		return message;
	}
}

	