class Solution {

  public String validIPAddress(String IP) {
    if(IP == null || IP.isEmpty())
      return "Neither";

    if(IP.indexOf(".") >= 0)
      return validateIPv4(IP);

    if(IP.indexOf(":") >= 0)
      return validateIPv6(IP);

    return "Neither";
  }

  private String validateIPv4(String ip) {
     if(ip.charAt(0) == '.' || ip.charAt(ip.length()-1) == '.')
      return "Neither";
    String[] components = ip.split("\\.");

    if(components.length != 4)
      return "Neither";

    for(String comp : components) {
      if(comp.isEmpty() || comp.length() > 3 || (comp.charAt(0) == '0' && comp.length() > 1))
        return "Neither";

      for(char ch : comp.toCharArray()) {
        if(ch < '0' || ch > '9')
          return "Neither";
      }

      int num = Integer.parseInt(comp);
      if(num < 0 || num > 255)
        return "Neither";
    }

    return "IPv4";
  }


  private String validateIPv6(String ip) {
    if(ip.charAt(0) == ':' || ip.charAt(ip.length()-1) == ':')
      return "Neither";

    String[] components = ip.split(":");
    if(components.length != 8)
      return "Neither";
     
     
    for(String comp : components) {
      if(comp.isEmpty() || comp.length() > 4)
        return "Neither";

      for(char ch : comp.toLowerCase().toCharArray()) {
        if((ch < '0' || ch > '9') && ch != 'a' && ch != 'b' && ch != 'c' && ch != 'd' && ch != 'e' && ch != 'f')
          return "Neither";
      }
    }

    return "IPv6";
  }

}