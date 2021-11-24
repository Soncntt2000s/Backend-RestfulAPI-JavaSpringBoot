package com.hybrid.api;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.hybrid.request.PostRequest;
import com.hybrid.response.BaseResponse;
import com.hybrid.response.PostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hybrid.repository.PostRepository;
import com.hybrid.response.BaseDataResponse;
import com.hybrid.service.IPostService;

@RestController
public class PostAPI {

	private static final Path CURRENT_FOLDER = Paths.get(System.getProperty("user.dir"));

	@Autowired
	private IPostService postService;

	@Autowired
	private PostRepository postRepo;

	@GetMapping(value = "/api/home")
	public BaseDataResponse<List<PostResponse>> getHomePost() {
		BaseDataResponse<List<PostResponse>> baseListHomePost = new BaseDataResponse<List<PostResponse>>();
		baseListHomePost.setReponseCode(200);
		baseListHomePost.setMessage("Get post successfully");
		baseListHomePost.setData(postService.getHomePost());
		return baseListHomePost;
	}

	@GetMapping(value = "api/post/news")
	public BaseDataResponse<List<PostResponse>> getPost() {
		BaseDataResponse<List<PostResponse>> baseListHomePost = new BaseDataResponse<List<PostResponse>>();
		baseListHomePost.setReponseCode(200);
		baseListHomePost.setMessage("Get post successfully");
		baseListHomePost.setData(postService.getHomePost());
		return baseListHomePost;
	}

	@PostMapping(value = "api/post/create")
	public BaseResponse create(@ModelAttribute PostRequest postRequest) throws IOException {
		Path staticPath = Paths.get("static");
		Path imagePath = Paths.get("images");
		if (!Files.exists(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath))) {
			Files.createDirectories(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath));
		}
		Path file = CURRENT_FOLDER.resolve(staticPath).resolve(imagePath)
				.resolve(postRequest.getImage().getOriginalFilename());
		try (OutputStream os = Files.newOutputStream(file)) {
			os.write(postRequest.getImage().getBytes());
		}

		String image = imagePath.resolve(postRequest.getImage().getOriginalFilename()).toString();
		return postService.save(postRequest, image);
	}
}
