package kr.allparking.bpm_AllParking.controller;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.allparking.bpm_AllParking.entity.KakaoAPI;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;


@Controller
@RestController
@RequiredArgsConstructor
public class HomeController {


        KakaoAPI kakaoApi = new KakaoAPI();

        @RequestMapping(value = "/auth/kakaologin")
        public ModelAndView login(@RequestParam("code") String code, HttpSession session) {
            // 1번 인증코드 요청 전달
            ModelAndView mav = new ModelAndView();
            // 2번 잉ㄴ증코드로 토큰 전달
            String accessToken = kakaoApi.getAccessToken(code);
            HashMap<String, Object> userInfo = kakaoApi.getUserInfo(accessToken);

            System.out.println("login info : " + userInfo.toString());
            if (userInfo.get("email") != null) {
                session.setAttribute("userId", userInfo.get("email"));
                session.setAttribute("Access_token", accessToken);
            }
            mav.addObject("userId", userInfo.get("email"));
            mav.setViewName("index");
            return mav;
        }







    @GetMapping("/")
    public String index(Model model) {

        String id = SecurityContextHolder.getContext().getAuthentication().getName();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Collection<? extends GrantedAuthority> cauthorities = authentication.getAuthorities();
        Iterator<? extends GrantedAuthority> iter = cauthorities.iterator();
        GrantedAuthority auth = iter.next();
        String role = auth.getAuthority();


        model.addAttribute("id", id);
        model.addAttribute("role", role);
        return "index";
    }

    @GetMapping("/me")
    public String me() {
        return "info/me";

    }

    @GetMapping("/team")
    public String team() {
        return "info/team";
    }

    @GetMapping("/location")
    public String location() {
        return "info/location";
    }

    @GetMapping("/charge")
    public String charge() {
        return "info/charge";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        return "redirect:/";
    }


}

