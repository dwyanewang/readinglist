/**
 * CopyRight (C)  2017-2018  武汉文思特信息工程有限公司
 * Author : WangWei
 * CreateTime : 2018/03/28 15:42
 * ProjectName : readinglist
 * Description : ReadingController控制层
 * Version : V1.0
 */
package readinglist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class ReadingController {
    private final ReadingRepository readingRepository;

    @Autowired
    public ReadingController(ReadingRepository readingRepository) {
        this.readingRepository = readingRepository;
    }

    //根据reader获取其阅读记录
    @GetMapping("/{reader}")
    public String readerBooks(
            @PathVariable("reader") String reader,
            Model model){
        List<Book> readingist = readingRepository.findByReader(reader);
        if (readingist != null) {
            model.addAttribute("books",readingist);
        }
        return "readingList";
    }

    @PostMapping("/{reader}")
    public String addToReadingList(
            @PathVariable("reader") String reader,
            Book book
    ){
        book.setReader(reader);
        readingRepository.save(book);
        return "redirect:/{reader}";
    }
}
