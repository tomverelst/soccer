package be.ordina.demo.ehb.soccer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ForwardTest {

    @Mock
    private Goal goal;

    @InjectMocks
    private Forward forward;

    @Test
    public void kick(){
        forward.kick();
        verify(goal).shoot(any(Football.class));
    }

}