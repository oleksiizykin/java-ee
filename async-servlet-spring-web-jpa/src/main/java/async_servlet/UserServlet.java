package async_servlet;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UserServlet extends HttpServlet {
    private final ExecutorService executorService = Executors.newFixedThreadPool(5);

//    @Override
//    protected void doGet(HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
//        try {
//            executorService.submit(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        Thread.sleep(400);
//                        resp.getWriter().println("hello from servlet");
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            }).get();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
//    }


    @Override
    protected void doGet(final HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final AsyncContext asyncContext = req.startAsync();
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    asyncContext.setTimeout(0);
                    PrintWriter writer = asyncContext.getResponse().getWriter();
                    Thread.sleep(400);
                    writer.println("hello from async servlet");
                    if (asyncContext.getRequest().isAsyncStarted()) {
                        asyncContext.complete();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


    }
}
