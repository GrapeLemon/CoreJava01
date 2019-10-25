import lombok.Data;

import java.util.List;

@Data
public class ResultVO {
    private String currentCity;
    private List<IndexVO> indexVOS;
    @Data
    public static class IndexVO {
        private String title;
        private String zs;
        private String tipt;
        private String des;
        private List<AnVO> anVOS;

        @Data
        public static class AnVO{
            private String name;
            private Integer age;
        }

    }
}
