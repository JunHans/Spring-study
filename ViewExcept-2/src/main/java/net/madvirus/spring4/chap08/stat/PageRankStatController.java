package net.madvirus.spring4.chap08.stat;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageRankStatController {

	@RequestMapping("/pagestat/rank")
	public String pageRank(Model model) {
		List<PageRank> pageRanks = Arrays.asList(
				new PageRank("PM", "임준한"),
				new PageRank("PL", "도현정"),
				new PageRank("대원", "고범종"),
				new PageRank("대원", "박예빈")
				);
		model.addAttribute("pageRankList", pageRanks);
		return "pageRank";   //뷰에서 필요로 하는 데이터 값들을 DTO객체로 모델에 담아서 View로 보내준다
	}

	@RequestMapping("/pagestat/rankreport")
	public String pageRankReport(Model model) {
		List<PageRank> pageRanks = Arrays.asList(
				new PageRank("PM", "임준한"),
				new PageRank("PL", "도현정"),
				new PageRank("대원", "고범종"),
				new PageRank("대원", "박예빈")
				);
		model.addAttribute("pageRankList", pageRanks);
		return "pageReport";  //뷰에서 필요로 하는 데이터 값들을 DTO객체로 모델에 담아서 View로 보내준다
	}
}











