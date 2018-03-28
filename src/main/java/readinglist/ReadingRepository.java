/**
 * CopyRight (C)  2017-2018  武汉文思特信息工程有限公司
 * Author : WangWei
 * CreateTime : 2018/03/28 15:40
 * ProjectName : readinglist
 * Description : ReadingRepository仓库接口
 * Version : V1.0
 */
package readinglist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ReadingRepository extends JpaRepository<Book,Long> {
    List<Book> findByReader(String reader);
}
