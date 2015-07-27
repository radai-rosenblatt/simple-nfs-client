package net.radai.simplenfs;

import net.radai.simplenfs.client.generated.RawNfs3Client;
import net.radai.simplenfs.client.generated.nfs3;
import org.dcache.simplenfs.SimpleNfsServer;
import org.dcache.xdr.IpProtocolType;
import org.dcache.xdr.RpcAuthTypeUnix;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.InetAddress;

public class RawNfs3ClientTest {
    protected SimpleNfsServer nfsServer;

    @Before
    public void setup() {
        nfsServer = new SimpleNfsServer(null, null, null, "bob");
    }

    @After
    public void teardown() throws IOException {
        nfsServer.close();
    }

    @Test
    public void testSomething() throws Exception {
        RawNfs3Client nfs3Client = new RawNfs3Client(
                InetAddress.getLocalHost(), nfsServer.getPort(),
                new RpcAuthTypeUnix(0, 0, new int[0], 0, "host"),
                nfs3.NFS_PROGRAM, nfs3.NFS_V3, IpProtocolType.TCP);
        boolean die = false;
        while (!die) {
            Thread.sleep(5000);
        }
    }
}
