# To learn more about how to use Nix to configure your environment
# see: https://developers.google.com/idx/guides/customize-idx-env
{ pkgs, ... }: {
  # Which nixpkgs channel to use.
  channel = "stable-24.05"; # or "unstable"
  # Use https://search.nixos.org/packages to find packages
  packages = [
    pkgs.zulu21
    pkgs.maven
  ];
  #  environment.systemPackages = [
  #   pkgs.maven
  # ];

   services.mysql = {
    enable = true;
    package = pkgs.mysql80;
  };
  # Sets environment variables in the workspace
  env = {};
  idx = {
    # Search for the extensions you want on https://open-vsx.org/ and use "publisher.id"
    extensions = [
      "vscjava.vscode-java-pack"
      "rangav.vscode-thunder-client"
      "redhat.java"
      "vscjava.vscode-java-dependency"
      "vscjava.vscode-java-test"
      "vscjava.vscode-maven"
      "Pivotal.vscode-boot-dev-pack"
      "vmware.vscode-spring-boot"
      "vscjava.vscode-spring-boot-dashboard"
      "cweijan.vscode-mysql-client2"
      "vscjava.vscode-java-debug"
    ];
    workspace = {
      # Runs when a workspace is first created with this `dev.nix` file
      onCreate = {
        install = "mvn clean install";
      };
      # Runs when a workspace is (re)started
      onStart = {
        run-server = "mvn spring-boot:run";
      };
    };
  };
}