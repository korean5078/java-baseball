package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 정답_체크() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("123", "456", "789", "139", "392", "923", "2");
                    assertThat(output()).contains("2스트라이크", "낫싱", "1볼", "2볼", "3볼", "3스트라이크", "게임 종료");
                },
                9, 2, 3
        );
    }

    @Test
    void 중복_체크() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("333"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 중복_체크2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("233"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_체크2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("ㅁㄴㅇ"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_체크3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
