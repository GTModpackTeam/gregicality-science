package gregicality.science.common.pipelike.pressure.net;

import gregicality.science.common.pipelike.pressure.PressurePipeData;
import gregtech.api.pipenet.WorldPipeNet;
import net.minecraft.world.World;

public class WorldPressureNet extends WorldPipeNet<PressurePipeData, PressurePipeNet> {

    private static final String DATA_ID = "gregtech.pressure_pipe_net";

    public WorldPressureNet(String name) {
        super(name);
    }

    public static WorldPressureNet getWorldPipeNet(World world) {
        WorldPressureNet netWorldData = (WorldPressureNet) world.loadData(WorldPressureNet.class, DATA_ID);
        if (netWorldData == null) {
            netWorldData = new WorldPressureNet(DATA_ID);
            world.setData(DATA_ID, netWorldData);
        }
        netWorldData.setWorldAndInit(world);
        return netWorldData;
    }

    @Override
    protected PressurePipeNet createNetInstance() {
        return new PressurePipeNet(this);
    }
}
