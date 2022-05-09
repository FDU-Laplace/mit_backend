package com.missiongroup.starring.modular.system.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import io.swagger.annotations.Api;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.missiongroup.starring.config.properties.StarringProperties;
import com.missiongroup.starring.core.util.FileUtil;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 
 * @ClassName: KaptchaController
 * @Description: 验证码控制器
 * @author TAIHUAYUN
 * @date 2018年4月9日 下午3:04:34
 *
 */
@ApiIgnore
@Controller
@RequestMapping("/kaptchaCtl")
public class KaptchaController {
	private static final Logger LOGGER = Logger.getLogger(KaptchaController.class);

	@Resource
	private StarringProperties starringProperties;

	@Autowired
	Producer producer;

	@ApiOperation(value = "生成验证码图片", notes = "生成验证码图片")
	@RequestMapping(method = RequestMethod.GET)
	public void index(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();

		response.setDateHeader("Expires", 0);

		// Set standard HTTP/1.1 no-cache headers.
		response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");

		// Set IE extended HTTP/1.1 no-cache headers (use addHeader).
		response.addHeader("Cache-Control", "post-check=0, pre-check=0");

		// Set standard HTTP/1.0 no-cache header.
		response.setHeader("Pragma", "no-cache");

		// return a jpeg
		response.setContentType("image/jpeg");

		// create the text for the image
		String capText = producer.createText();

		// store the text in the session
		session.setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);

		// create the image with the text
		BufferedImage bi = producer.createImage(capText);
		ServletOutputStream out = null;
		try {
			out = response.getOutputStream();
		} catch (IOException e) {
			e.printStackTrace();
			LOGGER.error(e);
		}

		// write the data out
		try {
			ImageIO.write(bi, "jpg", out);
		} catch (IOException e) {
			e.printStackTrace();
			LOGGER.error(e);
		}
		try {
			try {
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
				LOGGER.error(e);
			}
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
				LOGGER.error(e);
			}
		}
	}

	@ApiOperation(value = "生成验证码图片", notes = "根据pictureId生成验证码图片")
	@RequestMapping(value = "/{pictureId}", method = RequestMethod.GET)
	public void renderPicture(@PathVariable("pictureId") String pictureId, HttpServletResponse response) {
		String path = starringProperties.getFileUploadPath() + pictureId + ".jpg";
		try {
			byte[] bytes = FileUtil.toByteArray(path);
			response.getOutputStream().write(bytes);
		} catch (Exception e) {
			// 如果找不到图片就返回一个默认图片
			try {
				response.sendRedirect("/static/img/girl.gif");
			} catch (IOException e1) {
				e1.printStackTrace();
				LOGGER.error(e);
			}
		}
	}
}
