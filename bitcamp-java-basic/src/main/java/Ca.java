
public class Ca extends Veh {
  public Ca(String val) {
    name = super.name = val;
  }
  @Override
  public String getName(String val) {
    return "Car name:" +val;
  }

  public String getName(byte val[]) {
    return "Car name:" + val;
  }
}
